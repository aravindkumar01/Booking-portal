import decode from 'jwt-decode';
export class Constants {


    public static  userRole(){
        const token = localStorage.getItem('token');
        // decode the token to get its payload
        const tokenPayload = decode(token);        
        //return tokenPayload.;
        console.log(tokenPayload);
        return tokenPayload.scopes;
    }


    public static get username():string{
        const token = localStorage.getItem('token');
        // decode the token to get its payload
        const tokenPayload = decode(token);
        console.log(tokenPayload);
        return tokenPayload.sub;
        
    }
}
