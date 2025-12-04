
// export default TeamsList;
import React, { useEffect, useState } from "react";
import api from "../../api";
import "../../styles/layout.css";
import "../../styles/teams.css";
import { Link } from "react-router-dom";

// Import Bootstrap Icons as React components
import {
  EyeFill,
  PencilSquare,
  TrashFill,
  PlusCircle,
  PeopleFill,
} from "react-bootstrap-icons";

function TeamsList() {
  const [teams, setTeams] = useState([]);

  const loadTeams = () => {
    api.get("/teams").then((res) => setTeams(res.data));
  };

  useEffect(() => {
    loadTeams();
  }, []);

  const deleteTeam = (id) => {
    if (window.confirm("Are you sure you want to delete this team?")) {
      api.delete(`/teams/${id}`).then(() => loadTeams());
    }
  };

  return (
    <div className="container mt-4">

      {/* Header */}
      <div className="d-flex justify-content-between align-items-center mb-3">
        <h2 className="fw-bold">
          <PeopleFill className="text-primary me-2" size={30} />
          Team Management
        </h2>

        <Link to="/teams/add" className="btn btn-success shadow-sm">
          <PlusCircle className="me-1" />
          Add Team
        </Link>
      </div>

      {/* Table */}
      <table className="table table-hover table-bordered shadow-sm">
        <thead className="table-dark">
          <tr>
            <th>Team ID</th>
            <th>Team Name</th>
            <th>City</th>
            <th>Founded</th>
            <th>Coach</th>
            <th style={{ width: "350px" }}>Actions</th>
          </tr>
        </thead>

        <tbody>
          {teams.length > 0 ? (
            teams.map((team) => (
              <tr key={team.teamId}>
                <td>{team.teamId}</td>
                <td className="fw-semibold">{team.teamName}</td>
                <td>{team.teamCity}</td>
                <td>{team.teamFounded}</td>
                <td>{team.coachName}</td>

                <td>
                  {/* View Players Button */}
                  <Link
                    to={`/teams/${team.teamId}`}
                    className="btn btn-info btn-sm me-2"
                  >
                    <EyeFill className="me-1" />
                    Players
                  </Link>

                  {/* Edit */}
                  <Link
                    to={`/teams/edit/${team.teamId}`}
                    className="btn btn-warning btn-sm me-2"
                  >
                    <PencilSquare className="me-1" />
                    Edit
                  </Link>

                  {/* Delete */}
                  <button
                    className="btn btn-danger btn-sm"
                    onClick={() => deleteTeam(team.teamId)}
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
                No teams found.
              </td>
            </tr>
          )}
        </tbody>
      </table>
    </div>
  );
}

export default TeamsList;
