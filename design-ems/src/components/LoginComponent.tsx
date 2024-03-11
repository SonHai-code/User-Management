import { ErrorMessage, Field, Form, Formik, validateYupSchema } from "formik";
import React, { useState, useEffect } from "react";
import authService from "../services/auth.service";
import { object, string, number, date, InferType } from "yup";
import { Navigate } from "react-router-dom";

const LoginComponent = () => {
  const [redirect, setRedirect] = useState("");
  const [loading, setLoading] = useState(false);
  const [password, setPassword] = useState("");
  const [username, setUsername] = useState("");
  const [message, setMessage] = useState("");

  useEffect(() => {
    const currentUser = authService.getCurrentUser();
    if (currentUser) {
      setRedirect("/profile");
    }
  }, []);

  const validationSchema = object({
    username: string().required("This field is required!"),
    password: string().required("This field is required!"),
  });

  const handleLogin = async (formValue) => {
    setLoading(true);

    try {
      await authService.login(formValue.username, formValue.password);
      setRedirect("/profile");
    } catch (err) {
      const resMessage =
        (err.response && err.response.data && err.response.data.message) ||
        err.message ||
        err.toString();
      setMessage(resMessage);
      setLoading(false);
    }
  };

  if (redirect) {
    return <Navigate to={redirect} />;
  }

  const initialValues = { username, password };

  return (
    <div className="col-md-12">
      <div className="card card-container">
        <img
          src="//ssl.gstatic.com/accounts/ui/avatar_2x.png"
          alt="profile-img"
          className="profile-img-card"
        />

        <Formik
          initialValues={initialValues}
          validationSchema={validationSchema}
          onSubmit={handleLogin}
        >
          <Form>
            <div className="form-group">
              <label htmlFor="username">Username</label>
              <Field name="username" type="text" className="form-control" />
              <ErrorMessage
                name="username"
                component="div"
                className="alert alert-danger"
              />
            </div>

            <div className="form-group">
              <label htmlFor="password">Password</label>
              <Field name="password" type="password" className="form-control" />
              <ErrorMessage
                name="password"
                component="div"
                className="alert alert-danger"
              />
            </div>

            <div className="form-group">
              <button
                type="submit"
                className="btn btn-primary btn-block"
                disabled={loading}
              >
                {loading && (
                  <span className="spinner-border spinner-border-sm"></span>
                )}
                <span>Login</span>
              </button>
            </div>

            {message && (
              <div className="form-group">
                <div className="alert alert-danger" role="alert">
                  {message}
                </div>
              </div>
            )}
          </Form>
        </Formik>
      </div>
    </div>
  );
};

export default LoginComponent;
