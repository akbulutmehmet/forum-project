import { Routes,Route } from "react-router"
import Dashboard from "./pages/dashboard";
import Login from "./pages/login"
import Register from "./pages/register"
import Categories from "./pages/categories";
import NewCategory from "./pages/new-category";
import CategoryDetail from "./components/categoryDetail";
import PostDetail from "./components/postDetail";
function App() {
  
  return (
    <>
    <Routes>
      <Route path="/login" element={<Login />} />
      <Route path="/register" element={<Register />} />
      <Route path="/" element={sessionStorage.getItem("token") == null || sessionStorage.getItem("token") ==="" ?<Login />  : <Dashboard />} />
      <Route path="/dashboard" element={<Dashboard />} />
      <Route path="/categories" element={<Categories />} />
      <Route path="/new-category" element={<NewCategory />} />
      <Route path="/category/:categoryId" element={<CategoryDetail />} />
      <Route path="/post/:postId" element={<PostDetail />} />
    </Routes>
    </>
  );
}

export default App;
