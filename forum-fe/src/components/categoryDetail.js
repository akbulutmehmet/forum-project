import { useEffect, useState } from "react";
import { useParams } from "react-router";
import categoryService from "../services/CategoryService";
import Footer from "./footer";
import Header from "./header";
import Post from "./post";
import { Link } from "react-router-dom";
import Author from "./author";
const CategoryDetail = () => {
  const { categoryId } = useParams();
  const [category, setCategory] = useState({});
  const [posts, setPosts] = useState([]);

  useEffect(() => {
    categoryService.getCategoryById("/api3/api/v1/category/", categoryId, response => {
      setCategory(response.data);
      setPosts(response.data.posts);
    });
  }, [categoryId]);

  return (
    <>
      <Header />
      <div className="container">
        <div className="row">
          <div className="col-md-12 text-center border border-black mt-5 mb-5 pt-5 pb-5">
            <h1 className="display-1">{category.title}</h1>
            <p className="text-lead">{category.description}</p>
          </div>
          <div className="col-md-3">
          {(sessionStorage.getItem("userId") === category.userId ) ? 
            <button className="btn btn-lg btn-primary"
            
            >UPDATE</button>
            : ""  }
          </div>
          <Author userId={category.userId} />
          <div className="row">
            <div className="col-md-4" >
            <Link className="btn btn-lg btn-success" to={"/new-post/" + categoryId} >Create Post</Link>
            </div>
          </div>
          {posts.map((post, key) => (
            <Post key={key} title={post.title} id={post.id} />
          ))}
        </div>
      </div>
      <Footer />
    </>
  );
};

export default CategoryDetail;
