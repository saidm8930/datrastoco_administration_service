import React from 'react'

function Button(props) {
  return (
    <div className="mt-3">
        <button type={props.Type} className="bg-blue-600 text-white w-48 rounded-sm text-center">{props.title}</button>
    </div>
  )
}

export default Button
