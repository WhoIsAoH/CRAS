import {Endpoint} from "./endpoint";
export const Constraints={
    authUrl:`${Endpoint.baseUrl}/api/v1/auth`,
    saveUserUrl:`${Endpoint.baseUrl}/api/v1/auth/register`,
    getUserByEmail:`${Endpoint.baseUrl}/getUserByEmail`,
    getUserUrl: (id: number | undefined)=>`${Endpoint.baseUrl}/user/${id}`,
}
