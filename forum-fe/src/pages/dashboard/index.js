import { Carousel } from "react-bootstrap";
import Footer from "../../components/footer";
import Header from "../../components/header";
import slider1 from "../../images/slider-1.jpg"
import slider2 from "../../images/slider-2.jpg"
const Dashboard = () => {
    return (<>
        <Header />
    <div className="container-fluid">
            <div className="row">
                <div className="col-md-12">
    <Carousel>
        <Carousel.Item>
        <img
          className="img-fluid"
          src={slider1}
          alt="First slide"
        />
        <Carousel.Caption>
          <h3>First slide label</h3>
          <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
        </Carousel.Caption>
        </Carousel.Item>
        <Carousel.Item>
        <img
          className="img-fluid"
          src={slider2}
          alt="First slide"
        />
        <Carousel.Caption>
          <h3>First slide label</h3>
          <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
        </Carousel.Caption>
        </Carousel.Item>
    </Carousel>
                </div>
            </div>
        </div>
        <Footer />
    </>)
}
export default Dashboard;