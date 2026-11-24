import request from 'supertest';

const api = request(process.env.API_BASE_URL || 'http://localhost:8080');

describe('Browse Cats API', () => {

    let cats

    beforeAll(async () => {
        const response = await api.get('/api/getCats');

        expect(response.status).toBe(200);

        cats = response.body;
    });

    describe('GET /api/getCats', () => {

        test("Should return HTTP 200", async () => {
            const response = await api.get('/api/getCats');
            expect(response.status).toBe(200);
        });
    });
});