import axios from 'axios';

const API_URL = "http://localhost:8080/api";

class Service {
    getPoll(pollId) {
        return axios.get(API_URL + `/get-poll/${pollId}`)
    }

    postVote(pollId, optionId) {
        return axios.post(API_URL + "/post-vote", { pollId, optionId });
    }

    getVotes(pollId) {
        return axios.get(API_URL + `/get-votes/${pollId}`)
    }
}

export default new Service();