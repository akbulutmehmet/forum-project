import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';

const Navmenu = () => {

    return (
        <>
     <Navbar bg="primary" variant="dark">
        <Container>
          <Navbar.Brand href="/">Forum Project</Navbar.Brand>
          <Nav className="me-auto">
            <Nav.Link href="/categories">Categories</Nav.Link>
            <Nav.Link href="/profile">Profile</Nav.Link>
          </Nav>
        </Container>
      </Navbar>
        </>

)
}

export default Navmenu;