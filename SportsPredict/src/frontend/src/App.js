import logo from './logo.svg';
import './App.css';
import './index.js';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <h1>Sports Predictor</h1>
        <link rel="manifest" href="%PUBLIC_URL%/manifest.json" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossOrigin="anonymous"/>
      </header>
      <div className="App-body body-div">
        <br/>
        <div className="card main-card">
          <div className='image-body'>
            <h5 className="card-title">Leagues</h5>
          </div>
          <div className="card-body">
            <p className="card-text">Get League Info</p>
            <button className="btn btn-success pull-right" onClick={window['parseData']}>Try me out!</button>
          </div>
        </div>
        <div className="card main-card">
        <div className='image-body'>
          <h5 className="card-title">Match</h5>
        </div>
        <div className="card-body">
          <p className="card-text">Get Matches Info</p>
          <a href="http://localhost:8080/api/v1/match" className="btn btn-danger pull-right">Try me out!</a>
        </div>
      </div>
      <div className="card main-card">
        <div className='image-body'>
          <h5 className="card-title">Team</h5>
        </div>
        <div className="card-body">
          <p className="card-text">Get Teams Info</p>
          <a href="http://localhost:8080/api/v1/team" className="btn btn-info pull-right">Try me out!</a>
        </div>
      </div>
      </div>
    </div>
  );
}

export default App;
