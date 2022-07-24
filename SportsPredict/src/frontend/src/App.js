import logo from './logo.svg';
import './App.css';
import './index.js';
import TextField from '@mui/material/TextField'

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
            <a href="http://localhost:8080/api/v1/league" className="btn btn-success pull-right">Try me out!</a>
          </div>
        </div>
        <div className="card main-card">
        <div className='image-body'>
          <h5 className="card-title">Matches</h5>
        </div>
        <div className="card-body">
          <p className="card-text">Get Matches Info</p>
          <a href="http://localhost:8080/api/v1/match" className="btn btn-danger pull-right">Try me out!</a>
        </div>
      </div>
      <div className="card main-card">
        <div className='image-body'>
          <h5 className="card-title">Teams</h5>
        </div>
        <div className="card-body">
          <p className="card-text">Get Teams Info</p>
          <a href="http://localhost:8080/api/v1/team" className="btn btn-info pull-right">Try me out!</a>
        </div>
      </div>

      <div className="card main-card input">
        <div className='image-body'>
          <h5 className="card-title">Create League</h5>
        </div>
        <div className="card-body">
          <h3 className="card-text">Set League Info</h3>
          <form action="http://localhost:8080/api/v1/league" method="POST">
            <div class="form-group">
              <input type="text" class="form-control" name="name" aria-describedby="teamHelp" placeholder="Enter League Name"/>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
        </div>
      </div>

      <div className="card main-card input">
        <div className='image-body'>
          <h5 className="card-title">Create Match</h5>
        </div>
        <div className="card-body">
          <h3 className="card-text">Set Match Info</h3>
          <form action="http://localhost:8080/api/v1/match" method="POST">
            <div class="form-group">
              <input type="text" class="form-control" name="homeTeam" aria-describedby="matchHelp" placeholder="Enter Home Team Name"/>
            </div>
            <div class="form-group">
              <input type="text" class="form-control" name="awayTeam" aria-describedby="matchHelp" placeholder="Enter Away Team Name"/>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
        </div>
      </div>

      <div className="card main-card input">
        <div className='image-body'>
          <h5 className="card-title">Create Team</h5>
        </div>
        <div className="card-body">
          <h3 className="card-text">Set Team Info</h3>
          <form action="http://localhost:8080/api/v1/team" method="POST">
            <div class="form-group">
              <input type="text" class="form-control" name="name" aria-describedby="teamHelp" placeholder="Enter Team Name"/>
            </div>
            <div class="form-group">
              <input type="number" class="form-control" name="wins" placeholder="Wins"/>
            </div>
            <div class="form-group">
              <input type="number" class="form-control" name="losses" placeholder="Losses"/>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
        </div>
      </div>
      </div>
    </div>
  );
}

export default App;
