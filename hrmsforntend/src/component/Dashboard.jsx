import { useEffect, useState } from "react";
import { Link } from "react-router-dom";

function Dashboard() {
  const [attendance, setAttendance] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  useEffect(() => {
  async function fetchAttendance() {
    try {
      const response = await fetch(
        "http://localhost:8080/v1/user/attendance/all"
      );

      console.log("HTTP status:", response.status);

      const responseText = await response.text();
      console.log("API response:", responseText);

      if (!response.ok) {
        throw new Error(`HTTP error: ${response.status}`);
      }

      const data = JSON.parse(responseText);

      if (!Array.isArray(data)) {
        throw new Error("API did not return an array");
      }

      setAttendance(data);
      setError("");
    } catch (err) {
      console.error("Attendance error:", err);
      setError(err.message);
    } finally {
      setLoading(false);
    }
  }

  fetchAttendance();
}, []);

  return (
    <div className="container-fluid bg-light min-vh-100">
      <div className="row min-vh-100">

        {/* Sidebar */}
        <div className="col-md-2 bg-dark text-white p-4">
          <h3 className="mb-4">HRMS</h3>

          <ul className="nav flex-column gap-2">
            <li className="nav-item">
              <Link
                to="/dashboard"
                className="nav-link text-white active"
              >
                Dashboard
              </Link>
            </li>

            <li className="nav-item">
              <Link
                to="/employees"
                className="nav-link text-white"
              >
                Employees
              </Link>
            </li>

            <li className="nav-item">
              <Link
                to="/attendance"
                className="nav-link text-white"
              >
                Attendance
              </Link>
            </li>

            <li className="nav-item mt-4">
              <Link to="/" className="nav-link text-danger">
                Logout
              </Link>
            </li>
          </ul>
        </div>

        {/* Main Content */}
        <div className="col-md-10 p-4">

          {/* Navbar */}
          <div className="d-flex justify-content-between align-items-center bg-white rounded shadow-sm p-3 mb-4">
            <div>
              <h4 className="mb-1">Dashboard</h4>
              <small className="text-muted">
                Human Resource Management System
              </small>
            </div>

            <span className="badge bg-primary fs-6">
              Admin Panel
            </span>
          </div>

          {/* Welcome Section */}
          <div className="bg-primary text-white rounded p-4 mb-4">
            <h2>Welcome to HRMS!</h2>
            <p className="mb-0">
              Manage employees and track daily attendance from one place.
            </p>
          </div>

          {/* Summary Cards */}
          <div className="row g-4 mb-4">

            <div className="col-md-4">
              <div className="card border-0 shadow-sm h-100">
                <div className="card-body">
                  <h6 className="text-muted">Total Employees</h6>
                  <h2 className="text-primary">--</h2>
                  <p className="mb-0 text-muted">
                    Registered employees
                  </p>
                </div>
              </div>
            </div>

            <div className="col-md-4">
              <div className="card border-0 shadow-sm h-100">
                <div className="card-body">
                  <h6 className="text-muted">Present Today</h6>
                  <h2 className="text-success">--</h2>
                  <p className="mb-0 text-muted">
                    Employees marked present
                  </p>
                </div>
              </div>
            </div>

            <div className="col-md-4">
              <div className="card border-0 shadow-sm h-100">
                <div className="card-body">
                  <h6 className="text-muted">Absent Today</h6>
                  <h2 className="text-danger">--</h2>
                  <p className="mb-0 text-muted">
                    Employees not marked present
                  </p>
                </div>
              </div>
            </div>

          </div>

          {/* Quick Actions */}
          <div className="card border-0 shadow-sm mb-4">
            <div className="card-body p-4">
              <h5 className="mb-3">Quick Actions</h5>

              <div className="d-flex flex-wrap gap-3">
                <Link
                  to="/employees"
                  className="btn btn-primary"
                >
                  Manage Employees
                </Link>

                <Link
                  to="/attendance"
                  className="btn btn-success"
                >
                  View Attendance
                </Link>
              </div>
            </div>
          </div>

          {/* Recent Attendance */}
          <div className="card border-0 shadow-sm">
            <div className="card-body p-4">
              <h5 className="mb-3">Recent Attendance</h5>

              {loading ? (
                <p className="text-muted">
                  Loading attendance records...
                </p>
              ) : error ? (
                <div className="alert alert-danger">
                  {error}
                </div>
              ) : attendance.length === 0 ? (
                <div className="alert alert-info">
                  No attendance records found.
                </div>
              ) : (
                <div className="table-responsive">
                  <table className="table table-hover align-middle">
                    <thead className="table-light">
                      <tr>
                        <th>Employee ID</th>
                        <th>Date</th>
                        <th>In Time</th>
                        <th>Out Time</th>
                        <th>Status</th>
                      </tr>
                    </thead>

                    <tbody>
                      {attendance.map((record) => (
                        <tr key={record.attendanceId}>
                          <td>
                            {record.employee?.empId ??
                              record.employee?.empId ??
                              "-"}
                          </td>

                          <td>
                            {record.attendanceDate ?? "-"}
                          </td>

                          <td>
                            {record.inTime
                              ? new Date(
                                  record.inTime
                                ).toLocaleTimeString()
                              : "-"}
                          </td>

                          <td>
                            {record.outTime
                              ? new Date(
                                  record.outTime
                                ).toLocaleTimeString()
                              : "-"}
                          </td>

                          <td>
                            <span className="badge bg-success">
                              {record.comment || "Present"}
                            </span>
                          </td>
                        </tr>
                      ))}
                    </tbody>
                  </table>
                </div>
              )}
            </div>
          </div>

        </div>
      </div>
    </div>
  );
}

export default Dashboard;