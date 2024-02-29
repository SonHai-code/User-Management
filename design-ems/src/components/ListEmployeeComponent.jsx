import { useEffect, useState } from "react"
import { listEmployees } from "../services/EmployeeService";
import {useNavigate} from "react-router-dom"

const ListEmployeeComponent = () => {
    const [employees, setEmployees]= useState([]);

    const nagivator = useNavigate();

    // useEffect run everytime the state was changed
    useEffect(()=>{
        listEmployees().then(response => {
            setEmployees(response.data);
        }).catch(error => {
            console.log(error);
        })
    }
    ,[]);

    function addNewEmployee() {
        nagivator('/add-employee');
    }

    const updateEmployee = (employeeId) => {
        nagivator(`/edit-employee/${employeeId}`);
    }

  return (
    <div>
        <h2 className="text-center">List of Employees</h2>
        <button type="button" className="btn btn-primary" onClick={addNewEmployee}>Add</button>
        <table className="table table-striped table-border">
            <thead>
                <tr>
                    <th>Employee Id</th>
                    <th>Employee First Name</th>
                    <th>Employee Last Name</th>
                    <th>Employee Email</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
               {
                employees.map(employee => 
                    <tr key={employee.id}>
                        <td>{employee.id}</td>
                        <td>{employee.firstName}</td>
                        <td>{employee.lastName}</td>
                        <td>{employee.email}</td>
                        <td><button className="btn btn-info" onClick={() => updateEmployee(employee.id) }></button></td>
                    </tr>
                    )
               }
            </tbody>
        </table>
      
    </div>
  )
}

export default ListEmployeeComponent
