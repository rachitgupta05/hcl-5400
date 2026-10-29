import { useState } from "react";
import { useNavigate  } from "react-router-dom";

function Login() {
  const [empId, setEmpId] = useState("");
  const [password, setPassword] = useState("");
  const navigate=useNavigate();

  async function handleSubmit(e) {
  e.preventDefault();

  try {
    const response = await fetch(
      `http://localhost:8080/v1/user/login?empId=${encodeURIComponent(empId)}&password=${encodeURIComponent(password)}`,
      {
        method: "POST"
      }
    );

    const result = await response.text();

    console.log("Status:", response.status);
    console.log("Response:", JSON.stringify(result));

    if (response.ok) {
      navigate("/dashboard");
    } else {
      alert(result || "Login failed");
    }
  } catch (error) {
    console.error("Login error:", error);
    alert("Unable to connect to the server");
  }
}

  return (
    <div className="container mt-5">
      <div className="row justify-content-center">
        <div className="col-md-5">
          <div className="card shadow">
            <div className="card-body p-4">
              <h2 className="text-center mb-4">
                Employee Login
              </h2>

              <form onSubmit={handleSubmit}>
                <div className="mb-3">
                  <label htmlFor="empId" className="form-label">
                    Employee ID
                  </label>
                  <input
                    type="number"
                    id="empId"
                    className="form-control"
                    placeholder="Enter employee ID"
                    value={empId}
                    onChange={(e) => setEmpId(e.target.value)}
                    required
                  />
                </div>

                <div className="mb-3">
                  <label htmlFor="password" className="form-label">
                    Password
                  </label>
                  <input
                    type="password"
                    id="password"
                    className="form-control"
                    placeholder="Enter password"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                    required
                  />
                </div>

                <button
                  type="submit"
                  className="btn btn-primary w-100"
                  onClick={handleSubmit}
                >
                  Login
                </button>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Login;