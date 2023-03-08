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
    <div className="pt-4">
        <div className="text-3xl font-bold">
            <h2>Sign In</h2>
        </div>
        <div className="mt-4">
            <form onSubmit={(e)=>submit(e)}>
                <Input OnChange = {(e)=>handleUserRegData(e)} Id="username" Value = {userRegData.username} Type="text" fieldName="Username" />
                <Input OnChange = {(e)=>handleUserRegData(e)} Id="password" Value = {userRegData.password} Type="password" fieldName="Password" />
                <Button Type = "submit" title = "Sign In" />
            </form>
        </div>
        <div>
            <h6 className='text-red-600 text-md mt-2 text-center'>New user sign up first</h6>
            <div><NavLink to={"/register"}><Button title="Sign Up" /></NavLink></div>
        </div>
    </div>
  )
}

export default LoginPage 