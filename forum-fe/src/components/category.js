import { Link } from "react-router-dom";

const Category = ({id,title,description}) => {
    return (
        <div className="row  border border-black m-1 p-1">
            <div className="col-md-12">
                
            <Link to={"/category/"+id} > <h4 className="display-4">{title}</h4> </Link>
                <p>
                    {description}
                </p>
                
            </div>
        </div>
    );
}

export default Category;