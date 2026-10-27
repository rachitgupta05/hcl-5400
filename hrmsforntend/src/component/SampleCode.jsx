import React, { use, useEffect, useState } from 'react'

function SampleCode() {

  const[counter, setCounter]=useState(0);
  const[pointer, setPointer]=useState(100);

  useEffect(()=>{
    console.log("Counter=" + counter)
    console.log("pointer=" + pointer)
  },[counter,pointer])

  function updateCounter(){
    setCounter(counter+1)
  }
  function updatePointer(){
    setPointer(pointer-1)
  }

  return (
    <>
    <div>
      <h2>Counter value={counter}</h2>
      <h2>Pointer value={pointer}</h2>
      <button onClick={updateCounter}>Increment Counter</button>
      <button style={{marginLeft:'10px'}} onClick={updatePointer}>Decrement Pointer</button>
    </div>
    </>
  )
}

export default SampleCode