import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import TeamsList from "./components/teams/TeamsList";
import AddTeam from "./components/teams/AddTeam";
import EditTeam from "./components/teams/EditTeam";
import PlayersList from "./components/players/PlayersList";
import AddPlayer from "./components/players/AddPlayer";
import EditPlayer from "./components/players/EditPlayer";
import TeamPlayers from "./components/teams/TeamPlayers";
import "./styles/layout.css";

function App() {
  return (
    <Router>
      <nav>
        <Link to="/teams">Teams</Link>
        <Link to="/players">Players</Link>
      </nav>

      <Routes>
        {/* Teams */}
        <Route path="/teams" element={<TeamsList />} />
        <Route path="/teams/add" element={<AddTeam />} />
        <Route path="/teams/edit/:id" element={<EditTeam />} />
         <Route path="/teams/:id" element={<TeamPlayers />} />

        {/* Players */}
        <Route path="/players" element={<PlayersList />} />
        <Route path="/players/add" element={<AddPlayer />} />
        <Route path="/players/edit/:id" element={<EditPlayer />} />
       
        
      </Routes>
    </Router>
  );
}

export default App;
