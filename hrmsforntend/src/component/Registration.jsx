import React, { useState } from 'react'

function Registration() {

  const [empId, setEmpId] =useState();
  const [empName, setEmpName] =useState();
  const [empDesignation, setEmpDesignation] =useState();
  const [empStack, setEmpStack] =useState();
  const [empEmail, setEmpEmail] =useState();
  const [empPassword, setEmpPassword] =useState();

async function sendData(e){
  try {
    e.preventDefault()
    const server= await fetch("http://localhost:8080/v1/user/addemp",{
      method:'Post',
      body:JSON.stringify({
        emp_id: empId,
        emp_name: empName,
        designation: empDesignation,
        stack: empStack,
        email: empEmail,
        password: empPassword
      }),
      headers:{"Content-Type":"application/json"}
    });

    const status=await server.text();
    console.log(status);
    
    alert(status);
  } catch (e) {
    console.log(e);
    
  }
}

  return (
    <div>
      <form>
          <div class="form-group">
            <label for="id"> Employee ID</label>
            <input
              type="text"
              class="form-control"
              id="id"
              name="id"
              placeholder="Enter ID"
              onChange={(e)=>setEmpId(e.target.value)}
            />
          </div>

          <div class="form-group">
            <label for="emp_name">Employee Name</label>
            <input
              type="text"
              class="form-control"
              id="emp_name"
              name="emp_name"
              placeholder="Enter Employee Name"
              onChange={(e)=>setEmpName(e.target.value)}
            />
          </div>

          <div class="form-group">
            <label for="stack">Stack</label>
            <input
              type="text"
              class="form-control"
              id="stack"
              name="stack"
              placeholder="Enter Stack (e.g., Java, Python)"
              onChange={(e)=>setEmpStack(e.target.value)}
            />
          </div>
          
          <div class="form-group">
            <label for="email">Email</label>
            <input
              type="email"
              class="form-control"
              id="email"
              name="email"
              placeholder="Enter Email"
              onChange={(e)=>setEmpEmail(e.target.value)}
            />
          </div>

          <div class="form-group">
            <label for="designation">Designation</label>
            <input
              type="text"
              class="form-control"
              id="designation"
              name="designation"
              placeholder="Enter Designation"
              onChange={(e)=>setEmpDesignation(e.target.value)}
            />
          </div>

          <div class="form-group">
            <label for="password">Password</label>
            <input
              type="password"
              class="form-control"
              id="password"
              name="password"
              placeholder="Enter Password"
              onChange={(e)=>setEmpPassword(e.target.value)}
            />
          </div>

          <button 
          type="submit" 
          class="btn btn-primary" 
          onClick={sendData}
          >Submit</button>
        </form>
    </div>
  )
}

export default Registration