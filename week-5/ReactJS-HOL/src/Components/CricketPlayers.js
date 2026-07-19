import React from 'react';

export const ListOfPlayers = ({ players }) => {
  return (
    <div>
      {players.map((item, index) => (
        <li key={index}>Mr. {item.name} <span>{item.score}</span></li>
      ))}
    </div>
  );
};

export const Scorebelow70 = ({ players }) => {
  // Filter the players with scores below or equal to 70 using arrow functions
  const players70 = players.filter(item => item.score <= 70);

  return (
    <div>
      {players70.map((item, index) => (
        <li key={index}>Mr. {item.name} <span>{item.score}</span></li>
      ))}
    </div>
  );
};
