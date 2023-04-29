import { Routes,Route } from "react-router"
import Dashboard from "./pages/dashboard";
import Login from "./pages/login"
import Register from "./pages/register"
function App() {
  
  return (
    <>
    <Routes>
      <Route path="/login" element={<Login />} />
      <Route path="/register" element={<Register />} />
      <Route path="/" element={sessionStorage.getItem("token") == null || sessionStorage.getItem("token") ==="" ?<Login />  : <Dashboard />} />
      <Route path="/dashboard" element={<Dashboard />} />
    </Routes>
    </>
  );
}

export default App;
