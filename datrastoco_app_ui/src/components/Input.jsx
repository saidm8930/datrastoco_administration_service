import React from 'react'

function Input(props) {
  return (
    <div className='mt-3'>
        <h6 className='mb-1 text-gray-500'>{props.fieldName}</h6>
        <input type={props.Type} onChange={props.OnChange} id={props.Id} value={props.Value} className="border rounded text-gray-500 text-sm border-cyan-400 w-56 p-1 px-2 focus-none outline-none " />
    </div>
  )
}

export default Input