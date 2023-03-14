
import './App.css';
import LoginPage from './pages/LoginPage';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import RegisterPage from './pages/RegisterPage';
import Home from './pages/Home';
import DynimicForm from './pages/DynimicForm';
import DynamicForm from './pages/DynimicForm';

function App() {
  return (
    <BrowserRouter>
      <div className="App">
        <Routes>
          <Route>
            <Route  path="/" element={<DynamicForm />}/>
            <Route path="register" element={<RegisterPage />} />
            <Route path="home" element={<Home />} />
          </Route>
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;
