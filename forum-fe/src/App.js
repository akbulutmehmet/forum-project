import { Routes,Route } from "react-router"
import Dashboard from "./pages/dashboard";
import Login from "./pages/login"
import Register from "./pages/register"
import Categories from "./pages/categories";
import NewCategory from "./pages/new-category";
import CategoryDetail from "./components/categoryDetail";
import PostDetail from "./components/postDetail";
import { useEffect, useState } from "react";
import Newpost from "./pages/new-post";
function App() {
  const [isAuth,setAuth] = useState(false);
  useEffect(() => {
    const token = sessionStorage.getItem("token");
    setAuth(!!token);
  },[])
  return (
    <>
    <Routes>
      <Route path="/login" element={<Login />} />
      <Route path="/register" element={<Register />} />
      <Route path="/" element={isAuth ? <Dashboard /> : <Login />} />
      <Route path="/dashboard" element={isAuth ? <Dashboard /> : <Login />} />
      <Route path="/categories" element={isAuth ? <Categories /> : <Login />} />
      <Route path="/new-category" element={isAuth ? <NewCategory /> : <Login />} />
      <Route path="/category/:categoryId" element={isAuth ? <CategoryDetail /> : <Login />} />
      <Route path="/post/:postId" element={isAuth ? <PostDetail /> : <Login />} />
      <Route path="/new-post/:categoryId" element={isAuth ? <Newpost />: <Login />}  />
    </Routes>
    </>
  );
}

export default App;
