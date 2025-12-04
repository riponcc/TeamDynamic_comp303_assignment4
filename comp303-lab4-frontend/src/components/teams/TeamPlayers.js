import React, { useEffect, useState } from "react";
import { useParams, Link } from "react-router-dom";
import api from "../../api";

// Bootstrap Icons
import {
  ArrowLeftCircle,
  PersonLinesFill,
  PencilSquare,
  TrashFill,
  PlusCircle,
} from "react-bootstrap-icons";

function TeamPlayers() {
  const { id } = useParams(); // teamId from URL
  const [team, setTeam] = useState(null);
  const [players, setPlayers] = useState([]);

  const loadTeam = () => {
    api.get(`/teams/${id}`).then((res) => setTeam(res.data));
  };

  const loadPlayers = () => {
    api.get(`/teams/${id}/player`).then((res) => setPlayers(res.data));
  };

  useEffect(() => {
    loadTeam();
    loadPlayers();
  }, [id]);

  const deletePlayer = (playerId) => {
    if (window.confirm("Are you sure you want to delete this player?")) {
      api.delete(`/players/${playerId}`).then(() => loadPlayers());
    }
  };

  return (
    <div className="container mt-4">

      {/* BACK BUTTON */}
      <Link to="/teams" className="btn btn-secondary mb-3">
        <ArrowLeftCircle className="me-1" size={18} />
        Back to Teams
      </Link>

      {/* TEAM INFO CARD */}
      {team && (
        <div className="card mb-4 p-3 shadow-sm">
          <h3 className="mb-2">
            <PersonLinesFill className="text-primary me-2" size={26} />
            {team.teamName}
          </h3>
          <p className="text-muted mb-1"><strong>Team ID:</strong> {team.teamId}</p>
          <p className="text-muted mb-1"><strong>City:</strong> {team.teamCity}</p>
          <p className="text-muted mb-1"><strong>Founded:</strong> {team.teamFounded}</p>
          <p className="text-muted"><strong>Coach:</strong> {team.coachName}</p>
        </div>
      )}

      {/* PLAYERS HEADER + ADD BUTTON */}
      <div className="d-flex justify-content-between align-items-center mb-3">
        <h4 className="fw-bold">
          <PersonLinesFill className="text-success me-2" size={24} />
          Players
        </h4>

        <Link to={`/players/add/${id}`} className="btn btn-success shadow-sm">
          <PlusCircle className="me-1" size={18} />
          Add Player
        </Link>
      </div>

      {/* PLAYERS TABLE */}
      <table className="table table-hover table-bordered shadow-sm">
        <thead className="table-dark">
          <tr>
            <th>Player ID</th>
            <th>Name</th>
            <th>Position</th>
            <th>Number</th>
            <th>Age</th>
            <th style={{ width: "200px" }}>Actions</th>
          </tr>
        </thead>

        <tbody>
          {players.length > 0 ? (
            players.map((player) => (
              <tr key={player.playerId}>
                <td>{player.playerId}</td>
                <td className="fw-semibold">{player.playerName}</td>
                <td>{player.position}</td>
                <td>{player.jerseyNumber}</td>
                <td>{player.age}</td>

                <td>
                  {/* EDIT BUTTON */}
                  <Link
                    to={`/players/edit/${player.playerId}`}
                    className="btn btn-warning btn-sm me-2"
                  >
                    <PencilSquare className="me-1" />
                    Edit
                  </Link>

                  {/* DELETE BUTTON */}
                  <button
                    className="btn btn-danger btn-sm"
                    onClick={() => deletePlayer(player.playerId)}
                  >
                    <TrashFill className="me-1" />
                    Delete
                  </button>
                </td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan="6" className="text-center py-3">
                <TrashFill className="text-danger me-2" />
                No players found for this team.
              </td>
            </tr>
          )}
        </tbody>
      </table>
    </div>
  );
}

export default TeamPlayers;
