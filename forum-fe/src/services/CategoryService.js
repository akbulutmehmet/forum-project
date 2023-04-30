import Getaxios from "../utils/Getaxios"

class CategoryService  {
    getAllCategory = (url,callback) => {
        Getaxios(url).then((response) => {
            if(callback){
                callback(response);
            }
        }).catch((error) => {console.log(error)});
    };
}
const categoryService = new CategoryService();
export default categoryService;