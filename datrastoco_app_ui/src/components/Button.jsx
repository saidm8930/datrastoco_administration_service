import React from 'react'

function Button(props) {
  return (
    <div className="mt-3">
        <button type={props.Type} className="bg-cyan-500 text-white w-56  text-center p-1 ">{props.title}</button>
    </div>
  )
}

export default Button
