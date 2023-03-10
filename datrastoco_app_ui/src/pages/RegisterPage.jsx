import React,{useState} from 'react'
import Button from '../components/Button'
import Input from '../components/Input'

function RegisterPage() {

const [userRegData, setUserRegData] = useState({
    username: "",
    password: "",
});

const submit = (e) =>{
    e.preventDefault();
    fetch('http://127.0.0.1:8080/admin/v1/register',{
        method: 'POST',
        headers: {
            'content-Type': 'application/json'
        },
        body: JSON.stringify(userRegData),
    })
    .then(response => response.json())
    .then(data => {
        console.log('success: ', data )
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
    <div className="pt-4 flex justify-center ">
        <div>
            <div className="text-3xl font-bold text-center ">
                <h2>Sign Up</h2>
            </div>
            <div className="mt-4">
                <form onSubmit={(e)=>submit(e)}>
                    <Input OnChange = {(e)=>handleUserRegData(e)} Id="username" Value = {userRegData.username} Type="text" fieldName="Username" />
                    <Input OnChange = {(e)=>handleUserRegData(e)} Id="password" Value = {userRegData.password} Type="password" fieldName="Password" />
                    <Button Type="submit" title = "Sign Up" />
                </form>
            </div>
        </div>
    </div>
  )
}

export default RegisterPage