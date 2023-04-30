import { Routes,Route } from "react-router"
import Dashboard from "./pages/dashboard";
import Login from "./pages/login"
import Register from "./pages/register"
import Categories from "./pages/categories";
function App() {
  
  return (
    <>
    <Routes>
      <Route path="/login" element={<Login />} />
      <Route path="/register" element={<Register />} />
      <Route path="/" element={sessionStorage.getItem("token") == null || sessionStorage.getItem("token") ==="" ?<Login />  : <Dashboard />} />
      <Route path="/dashboard" element={<Dashboard />} />
      <Route path="/categories" element={<Categories />} />
    </Routes>
    </>
  );
}

export default App;
