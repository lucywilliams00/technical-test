import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import VotingPage from './VotingPage';
import reportWebVitals from './reportWebVitals';
import './Fonts/Outfit-Regular.ttf';
import './Fonts/Outfit-Bold.ttf';
import ConfirmationPage from './ConfirmationPage';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <ConfirmationPage />
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
