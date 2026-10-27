import Dashboard from "./component/Dashboard"
import Home from "./component/Home"
import Login from "./component/Login"
import Registration from "./component/Registration"
import SampleCode from "./component/SampleCode"
import UsefetchApi from "./component/UsefetchApi"
import { BrowserRouter, Route, Routes } from 'react-router-dom'

function App() {
  // const employee = [
  //   {
  //     "ename": "Rahul",
  //     "empid": "101"
  //   },
  //   {
  //     "ename": "Rohan",
  //     "empid": "102"
  //   },
  //   {
  //     "ename": "Shyam",
  //     "empid": "103"
  //   },
  //   {
  //     "ename": "Mohan",
  //     "empid": "104"
  //   }
  // ]
  return (
    <>
      <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home/>}></Route>
        <Route path="/login" element={<Login/>}></Route>
        <Route path="/dashboard" element={<Dashboard/>}></Route>
        <Route path="/registration" element={<Registration/>}></Route>
      </Routes>
      </BrowserRouter>
    </>
  )
}

export default App
