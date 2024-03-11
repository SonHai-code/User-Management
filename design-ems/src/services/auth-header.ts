/*
This function return JSON type.
*/

export default function authHeader() {
  const userStr = localStorage.getItem("user");
  let user;
  if (userStr) {
    user = JSON.parse(userStr);
  }
  if (user && user.accessToken) {
    return { Authorization: "Bearer " + user.accessToken };
  } else {
    return { Authorication: "" };
  }
}
