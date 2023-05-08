import Getaxios from "../utils/Getaxios";

class ProfileService  { 
    getProfileByUserId = (url,userId,callback) => {
        Getaxios(url+userId).then((response) => {
            if(callback) {
                callback(response);
            }
        }).catch((error) => {
            console.log(error);
        });
    }
}
const profileService = new ProfileService();
export default profileService;