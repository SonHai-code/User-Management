
const ListEmployeeComponent = () => {
    const data = [
        {
            "id": 1,
            "firstName": "Hai",
            "lastName": "Tran",
            "email": "hai@gmail.com"
        }, 
        {
            "id": 2,
            "firstName": "Tuan",
            "lastName": "Le",
            "email": "tuanle@gmail.com"
        },   {
            "id": 3,
            "firstName": "Bach",
            "lastName": "Tran",
            "email": "bachtran@gmail.com"
        }, 
    ]
  return (
    <div>
        <h2>List of Employees</h2>
        <table>
            <thead>
                <tr>
                    <th>Employee Id</th>
                    <th>Employee First Name</th>
                    <th>Employee Last Name</th>
                    <th>Employee Email</th>
                </tr>
            </thead>
            <tbody>
               {
                data.map(employee => 
                    <tr key={employee.id}>
                        <td>{employee.id}</td>
                        <td>{employee.firstName}</td>
                        <td>{employee.lastName}</td>
                        <td>{employee.email}</td>
                    </tr>
                    )
               }
            </tbody>
        </table>
      
    </div>
  )
}

export default ListEmployeeComponent
