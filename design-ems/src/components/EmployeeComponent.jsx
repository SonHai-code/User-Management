import { useEffect, useState } from "react";
import {
  createEmployee,
  getEmployee,
  updateEmployee,
} from "../services/EmployeeService";
import { useNavigate, useParams } from "react-router-dom";

const EmployeeComponent = () => {
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");

  const { id } = useParams();

  const [errors, setErrors] = useState({
    firstName: "",
    lastName: "",
    email: "",
  });

  // Show errors when requirement is invalid.
  const validateForm = () => {
    let valid = true;

    const renderError = { ...errors };

    if (firstName.trim()) {
      renderError.firstName = "";
    } else {
      valid = false;
      renderError.firstName = "The first name is required!";
    }

    if (lastName.trim()) {
      renderError.lastName = "";
    } else {
      valid = false;
      renderError.lastName = "The last name is required!";
    }

    if (email.trim()) {
      renderError.email = "";
    } else {
      valid = false;
      renderError.email = "The email is required!";
    }

    setErrors(renderError);

    return valid;
  };

  const pageTitle = () => {
    if (id) {
      return <h2 className="text-center">Update Employee</h2>;
    } else {
      return <h2 className="text-center">Add Employee</h2>;
    }
  };

  const navigator = useNavigate();

  useEffect(() => {
    if (id) {
      getEmployee(id)
        .then((res) => {
          setFirstName(res.data.firstName);
          setLastName(res.data.lastName);
          setEmail(res.data.email);
        })
        .catch((err) => {
          console.log(err);
        });
    }
  }, [id]);

  const saveOrUpdateEmployee = (e) => {
    e.preventDefault();

    if (validateForm()) {
      const employee = { firstName, lastName, email };

      if (id) {
        updateEmployee(id, employee)
          .then((res) => {
            console.log(res.data);
            navigator("/employees");
          })
          .catch((err) => {
            console.log(err);
          });
      } else {
        createEmployee(employee)
          .then((response) => {
            console.log(response.data);
            navigator("/employees");
          })
          .catch((err) => console.log(err));
      }
    }
  };

  return (
    <div className="container">
      <br />
      <br />
      <div className="row p-35">
        <div className="card col-md-6 offset-md-3 offset-md-3">
          {pageTitle()}
          <div className="card-body">
            <form>
              <div className="form-group mb2">
                <label className="form-label">First Name: </label>
                <input
                  type="text"
                  placeholder="Enter your First Name"
                  name="firstName"
                  value={firstName}
                  className={`form-control ${errors.firstName ? "is-invalid" : ""}`}
                  onChange={(e) => {
                    setFirstName(e.target.value);
                  }}
                />
                {errors.firstName && (
                  <div className="invalid-feedback">{errors.firstName}</div>
                )}
              </div>
              <div className="form-group mb2">
                <label className="form-label">Last Name: </label>
                <input
                  type="text"
                  placeholder="Enter your Last Name"
                  name="lastName"
                  value={lastName}
                  className={`form-control ${errors.lastName ? "is-invalid" : ""}`}
                  onChange={(e) => {
                    setLastName(e.target.value);
                  }}
                />
                {errors.lastName && (
                  <div className="invalid-feedback">{errors.lastName}</div>
                )}
              </div>
              <div className="form-group mb2">
                <label className="form-label">Email: </label>
                <input
                  type="email"
                  placeholder="Enter your Email Address:"
                  name="email"
                  value={email}
                  className={`form-control ${errors.email ? "is-invalid" : ""}`}
                  onChange={(e) => {
                    setEmail(e.target.value);
                  }}
                />
                {errors.email && (
                  <div className="invalid-feedback">{errors.email}</div>
                )}
              </div>
              <button
                className="btn btn-success"
                type="submit"
                onClick={saveOrUpdateEmployee}
              >
                Submit
              </button>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};

export default EmployeeComponent;
