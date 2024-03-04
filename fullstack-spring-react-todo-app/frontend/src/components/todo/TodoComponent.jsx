import React, { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { Formik, Form, Field, ErrorMessage } from "formik";

import { retrieveSingleTodoApi, updateTodoApi } from "./api/TodoApiService.jsx";
import { useAuth } from "./security/AuthContext.jsx";

export default function TodoComponent() {
  const [description, setDescription] = useState("Loading description");
  const [targetDate, setTargetDate] = useState("");

  const { id } = useParams();

  const navigate = useNavigate();

  const authContext = useAuth();

  useEffect(() => retrieveTodo(), [id]);

  function retrieveTodo() {
    retrieveSingleTodoApi(authContext.username, id)
      .then((response) => {
        setDescription(response.data.description);
        setTargetDate(response.data.targetDate);
      })
      .catch((error) => console.log(error));
  }

  function onSubmitForm(values) {
    const todo = {
      id: id,
      username: authContext.username,
      description: values.description,
      targetDate: values.targetDate,
      done: false,
    };
    updateTodoApi(authContext.username, id, todo)
      .then((response) => {
        navigate("/todos")
      })
      .catch((error) => console.log(error));
  }

  function validate(values) {
    let errors = {};

    if (values.description.length < 5) {
      errors.description = "Enter at least 5 characters for description.";
    }

    if (values.targetDate === null) {
      errors.targetDate = "Enter a valid target date.";
    }

    return errors;
  }

  return (
    <div className="container">
      <h1>Enter TODO details</h1>
      <div>
        <Formik
          initialValues={{ description, targetDate }}
          enableReinitialize={true}
          onSubmit={onSubmitForm}
          validate={validate}
          validateOnChange={false}
          validateOnBlur={false}
        >
          {(props) => (
            <Form>
              <ErrorMessage
                name="description"
                component="div"
                className="alert alert-warning"
              />
              <ErrorMessage
                name="targetDate"
                component="div"
                className="alert alert-warning"
              />
              <fieldset className="form-group">
                <Field
                  type="text"
                  name="description"
                  className="form-control"
                />
              </fieldset>
              <fieldset className="form-group">
                <Field type="date" name="targetDate" className="form-control" />
              </fieldset>
              <div>
                <button type="submit" className="btn btn-success m-5">
                  Save
                </button>
              </div>
            </Form>
          )}
        </Formik>
      </div>
    </div>
  );
}
