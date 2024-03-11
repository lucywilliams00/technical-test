/*
 * to view the database values, go to:
 * http://localhost:8080/h2-ui
 * credentials: user, pass
 */

import React from 'react';
import { BrowserRouter as Router, Routes as Switch, Route } from 'react-router-dom';
import VotingPage from './VotingPage';
import ConfirmationPage from './ConfirmationPage';

function Routes() {
    return (
        <div>
            <Router>
                <Switch>
                    <Route exact path="/" element={<VotingPage/>}></Route>
                    <Route exact path="/confirmation" element={<ConfirmationPage/>}></Route>
                </Switch>
            </Router>
        </div>
    );
}

export default Routes;