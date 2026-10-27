import React, { use, useEffect, useState } from 'react'

function UsefetchApi() {

  const[serverData, setServerData] =useState([])
  useEffect(()=>{
    async function getData(){
      try {
        const serverData=await fetch("http://localhost:8080/getemployees");
        const jsonData= await serverData.json();
        setServerData(jsonData);
        console.log(serverData);
        
        console.log(jsonData);
        
      } catch (e) {
        console.log("Error is:", e);
      }
    }
    getData();

  },[])

  
  return (
    <div>
      {
        // JSON.stringify(serverData)
        
        serverData.map((data)=>(
        <h2 key={data}>{JSON.stringify(data)}</h2>
        ))
      }
    </div>
  )
}

export default UsefetchApi