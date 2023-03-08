import React from 'react'

function Input(props) {
  return (
    <div className='mt-3'>
        <h6>{props.fieldName}</h6>
        <input type={props.Type} onChange={props.OnChange} id={props.Id} value={props.Value} className="border border-blue-400 rounded-sm w-48" />
    </div>
  )
}

export default Input