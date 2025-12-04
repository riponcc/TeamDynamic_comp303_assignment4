
// export default PlayersList;
import React, { useEffect, useState } from "react";
import api from "../../api";
import "../../styles/layout.css";
import "../../styles/players.css";
import { Link } from "react-router-dom";

// React-Bootstrap-Icons
import {
  PlusCircle,
  PencilSquare,
  TrashFill,
  PersonFill,
} from "react-bootstrap-icons";

function PlayersList() {
  const [players, setPlayers] = useState([]);

  const loadPlayers = () => {
    api.get("/players").then((res) => setPlayers(res.data));
  };

  useEffect(() => {
    loadPlayers();
  }, []);

  const deletePlayer = (id) => {
    if (window.confirm("Are you sure you want to delete this player?")) {
      api.delete(`/players/${id}`).then(() => loadPlayers());
    }
  };

  return (
    <div className="container mt-4">
      {/* Header */}
      <div className="d-flex justify-content-between align-items-center mb-3">
        <h2 className="fw-bold">
          <PersonFill className="text-primary me-2" size={30} />
          Players
        </h2>

        <Link to="/players/add" className="btn btn-success shadow-sm">
          <PlusCircle className="me-1" size={18} />
          Add Player
        </Link>
      </div>

      {/* Player Cards Grid */}
      <div className="row">
        {players.map((p) => (
          <div key={p.playerId} className="col-md-4 mb-4">
            <div className="card shadow-sm player-card p-3">
              <h4 className="fw-semibold">
                <PersonFill className="text-secondary me-2" />
                {p.playerName || `${p.firstName} ${p.lastName}`}
              </h4>

              <div className="mt-2">
                <p><strong>Player ID:</strong> {p.playerId}</p>
                <p><strong>Position:</strong> {p.position}</p>
                <p><strong>Jersey #:</strong> {p.jerseyNumber}</p>
                <p><strong>Age:</strong> {p.age}</p>
                <p><strong>Team ID:</strong> {p.teamId}</p>
              </div>

              {/* ACTION BUTTONS */}
              <div className="d-flex justify-content-between mt-3">
                <Link
                  to={`/players/edit/${p.playerId}`}
                  className="btn btn-warning btn-sm"
                >
                  <PencilSquare className="me-1" /> Edit
                </Link>

                <button
                  className="btn btn-danger btn-sm"
                  onClick={() => deletePlayer(p.playerId)}
                >
                  <TrashFill className="me-1" /> Delete
                </button>
              </div>
            </div>
          </div>
        ))}

        {players.length === 0 && (
          <div className="text-center mt-5">
            <TrashFill className="text-danger me-2" size={25} />
            No players found.
          </div>
        )}
      </div>
    </div>
  );
}

export default PlayersList;

