import {Endpoint} from "./endpoint";
export const Constraints={
    authUrl:`${Endpoint.baseUrl}/api/v1/auth`,
    saveUserUrl:`${Endpoint.baseUrl}/api/v1/auth/register`,
    getUserUrl:(id:number)=>`${Endpoint.baseUrl}/user/${id}`,
}
