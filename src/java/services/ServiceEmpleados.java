package services;

import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import models.Empleado;
import repositories.RepositoryEmpleados;

@Path("/empleados")
public class ServiceEmpleados {

    RepositoryEmpleados repo;

    public ServiceEmpleados() {
        this.repo = new RepositoryEmpleados();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getEmpleados() throws SQLException {
        List<Empleado> empleados = this.repo.getEmpleados();
        Gson converter = new Gson();
        String json = converter.toJson(empleados);
        return json;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/oficios")
    public String getOficios() throws SQLException {
        List<String> oficios = this.repo.getOficios();
        Gson converter = new Gson();
        String json = converter.toJson(oficios);
        return json;
    }

    @PUT
    @Path("/incrementaroficios/{oficio}/{incremento}")
    public Response incrementarSalarioOficios(@PathParam("oficio") String oficio,
            @PathParam("incremento") String incremento) throws SQLException {
        int inc = Integer.parseInt(incremento);
        this.repo.incrementarSalarioOficio(oficio, inc);
        return Response.status(200).build();
    }
}
