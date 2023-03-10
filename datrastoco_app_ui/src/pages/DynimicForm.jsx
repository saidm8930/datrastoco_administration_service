import React, { useState } from 'react'

function DynamicForm() {

  const [inputField, setInputField] = useState([]);
 


  const addInput = () => {
      const newInput  = [...inputField];
      newInput.push({
        title: "",
        content: ""
      })
      setInputField(newInput);
  }

  const removeInput = (index) => {

    const currentInputField = [...inputField]
    currentInputField.splice(index, 1)
    setInputField(currentInputField)
  }

  const handleInputValueChange = (index, e) =>{
      let values = [...inputField];
      const updatedValue = e.target.name;
      values[index][updatedValue] = e.target.value;

      setInputField(values);
  }

  console.log(inputField);


  return (
    <div className='flex flex-wrap justify-center items-center'>
      <div className='w-7/12 text-center'>
        <h1 className='font-serif text-xl underline mb-2 font-bold text-cyan-500 pt-6'>FORM</h1>
        <p className='text-sm text-gray-500 font-serif'>Please add field to povide your particulars that you intend to provide.</p>
        <div>{
          inputField.map((input, index) =>
            <div key={index}> 
                  <div className='flex flex-wrap justify-center mt-4 p-2'>
                    <div className='border border-gray-200 p-1'>
                      <input 
                        name='title' 
                        placeholder='Title. Eg: First Name or Phone'
                        className='border-r font-serif text-gray-500 border-gray-200 outline-none px-2  text-md text-sm py-1 mr-2 ' 
                        onChange={(e) => handleInputValueChange(index, e)}
                        
                      /> 
                      <input 
                        name='content' 
                        placeholder='Contents. Eg: Azrathy or +255 xxxxxx'
                        className='text-gray-500 font-serif outline-none px-2  text-md w-96 py-1 text-sm ' 
                        onChange={(e) => handleInputValueChange(index, e)}
                        
                      /> 
                    </div>
                    <div className='ml-2 cursor-pointer bg-white shadow  w-10 h-10 font-md text-xl' onClick={()=> removeInput(index)}><label className='cursor-pointer text-gray-500'>x</label></div>
                  </div>
            </div>
          )}
        </div>
        <button className='bg-cyan-500 w-48 p-1 py-0 h-7 mt-2 text-white' onClick={()=>addInput()}><span className='border-r border-r-white mr-2'>+ </span>Add Field</button>
      </div>
      <div>
        <div><h6 className='text-cyan-500 text-md font-serif border-b mb-2'>Review your form</h6></div>
          {
            inputField.map((field, index) => (
              <div className='mt-3' key={index}>
                <label className='font-serif text-gray-500'>{field.title} :</label><label className='font-serif text-gray-500'> {field.content}</label>
              </div>
            ))
          }
        </div>

    </div>
  )
}

export default DynamicForm