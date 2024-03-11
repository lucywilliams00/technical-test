import React from 'react';
import Service from './Service';
import logo from './Images/logo.png';

class ConfirmationPage extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            totalVotes: 0,
            results: []
        }
    }

    componentDidMount() {
        const pollId = 1;
        var currentTotalVotes = 0;
        Service.getVotes(pollId).then(response => {
            for (var i = 0; i < response.data.length; i++) {
                currentTotalVotes += response.data[i].votes;
            }
            this.setState(
                {
                    totalVotes: currentTotalVotes,
                    results: response.data.sort((a, b) => (a.votes <= b.votes) ? 1 : -1)
                }
            )
        });
    }

    hardcodedOptionText(optionId) {
        switch (optionId) {
            case 1:
                return "Manchester City"
            case 2:
                return "Arsenal"
            case 3:
                return "Liverpool"
            default:
                return "Error"
        }
    }

    render() {
        const {totalVotes, results} = this.state;
        return (
            <div className='app'>
                <img id='logo' src={logo} alt="Dizplai Logo"/>
                <h1 className='heading'>Thank you for your response!</h1>
                {results.map(result => <div className='inline'>
                    <p className='result'>{this.hardcodedOptionText(result.optionId)} {Math.round((result.votes/totalVotes)*100)}%</p>
                    </div>)}
            </div>
        );
    }
}

export default ConfirmationPage;
