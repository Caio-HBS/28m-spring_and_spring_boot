import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { Formik, Form, Field } from "formik";

import { retrieveSingleTodoApi } from "./api/TodoApiService.jsx";
import { useAuth } from "./security/AuthContext.jsx";

export default function TodoComponent() {
  const [description, setDescription] = useState("Loading description");
  const [targetDate, setTargetDate] = useState("");

  const { id } = useParams();

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
    console.log(values);
  }

  return (
    <div className="container">
      <h1>Enter TODO details</h1>
      <div>
        <Formik
          initialValues={{ description, targetDate }}
          enableReinitialize={true}
          onSubmit={onSubmitForm}
        >
          {(props) => (
            <Form>
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
