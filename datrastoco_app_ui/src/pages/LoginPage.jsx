import React, { useState } from 'react'
import { NavLink, useNavigate } from 'react-router-dom'
import Button from '../components/Button'
import Input from '../components/Input'

function LoginPage() {

    const navigate = useNavigate();

    const [userRegData, setUserRegData] = useState({
        username: "",
        password: "",
    });
    
    const submit = (e) =>{
        e.preventDefault();
        fetch('http://127.0.0.1:8080/admin/v1/login',{
            method: 'POST',
            headers: {
                'content-Type': 'application/json'
            },
            body: JSON.stringify(userRegData),
        })
        
        .then(data => {
            console.log('success: ', data )
            navigate("/home");
        })
        .catch((error) => {
            console.log('Error: ', error)
        })
    
    
    }
    
    const handleUserRegData = (e) => {
        const newUserRegData = {...userRegData}
        newUserRegData[e.target.id] = e.target.value;
        setUserRegData(newUserRegData);
        console.log(newUserRegData);
    }
    
  return (
    <div className="pt-4 mt-10 flex justify-center items-center  ">
        <div className='flex flex-wrap items-center justify-center p-2  bg-white shadow'>
            <div className='mr-4'>
                <img src="bussines.jpg" alt="" width={460}/>
            </div>
            <div>
                <div className="text-3xl font-bold">
                    <h2 className='text-center'>Sign In</h2>
                </div>
                <div className="mt-4">
                    <form onSubmit={(e)=>submit(e)}>
                        <Input OnChange = {(e)=>handleUserRegData(e)} Id="username" Value = {userRegData.username} Type="text" fieldName="Username" />
                        <Input OnChange = {(e)=>handleUserRegData(e)} Id="password" Value = {userRegData.password} Type="password" fieldName="Password" />
                        <Button Type = "submit" title = "Sign In" />
                    </form>
                </div>
                <div>
                    <div className='mt-3'>
                        <NavLink className="mr-2" to={"/register"}><span>Forgot password?</span></NavLink>
                        <NavLink to={"/register"}><span className='text-blue-600 ml-3 '>Sign Up</span></NavLink>
                    </div>
                </div>
            </div>
        </div>
    </div>
  )
}

export default LoginPage 