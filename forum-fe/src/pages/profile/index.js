import { useEffect, useState } from "react";
import Footer from "../../components/footer";
import Header from "../../components/header";
import profileService from "../../services/ProfileService";

const Profile = ({GlobalState}) => {
    const [profile,setProfile] = useState({});
    const {userId} = GlobalState;
    useEffect(() => {
        profileService.getProfileByUserId("/api2/api/v1/profile/",userId,(response) => {
            setProfile(response.data);
        })
    },[userId]);
    
    return (<>
    <Header />
        <div className="container">
            <div className="row justify-content-center">
                <div className="col-md-5">
                    <h1 className="display-2 text-uppercase text-center">Profile</h1>
                    <div className="form-group mt-3">
                        <label htmlFor="name">Name</label>
                        <input defaultValue={profile.name || ""} 
                        className="form-control" 
                        id="name" 
                        type="text" />
                    </div>
                    <div className="form-group mt-3">
                        <label htmlFor="surname">Surname</label>
                        <input 
                        defaultValue={profile.surname || ""} 
                        className="form-control" 
                        id="surname" 
                        type="text" />
                    </div>
                
                    <div className="form-group mt-3">
                        <label htmlFor="city">City</label>
                        <input 
                        defaultValue={profile.city || ""} 
                        className="form-control" 
                        id="city" 
                        type="text" />
                    </div>
                    <div className="form-group mt-3">
                        <label htmlFor="country">Country</label>
                        <input 
                        defaultValue={profile.country || ""}
                        className="form-control" 
                        id="country" 
                        type="text" />
                    </div>
                    <div className="form-group mt-3">
                    <button className="btn btn-lg btn-outline-success" type="button" >Update</button>
                    </div>
                </div>
            </div>
        </div>
    <Footer />
    </>);
}
export default Profile;