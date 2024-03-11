import React, { useState, useEffect } from "react";
import { Formik, Field, Form, ErrorMessage } from "formik";
import { object, string, number, date, InferType } from "yup";

const RegisterComponent = () => {
  const [username, setUsername] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [successful, setSuccessful] = useState(false);
  const [message, setMessage] = useState("");

  const validationSchema = object().shape({
    username: string()
      .test(
        "len",
        "The username must be between 3 and 20 characters.",
        (value, context) => value?.toString.length >= 6
      )
      .required("This field is required!"),

    email: Yup.string()
      .email("This is not a valid email.")
      .required("This field is required!"),
    password: Yup.string()
      .test(
        "len",
        "The password must be between 6 and 40 characters.",
        (val) =>
          val && val.toString().length >= 6 && val.toString().length <= 40
      )
      .required("This field is required!"),
  });

  return <div>RegisterComponent</div>;
};

export default RegisterComponent;
