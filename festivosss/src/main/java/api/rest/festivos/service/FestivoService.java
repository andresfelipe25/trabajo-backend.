package api.rest.festivos.service;

import org.springframework.stereotype.Service;

import api.rest.festivos.repository.FestivoRepository;

import java.time.LocalDate;

@Service
public class FestivoService {
    private final FestivoRepository festivoRepository;

    public static void main(String[] args) {
        int anio = 1999;
        LocalDate domingoDePascua = calcularDomingoDePascua(anio);
        System.out.println("Domingo de Pascua calculado para " + anio + ": " + domingoDePascua);
    }

    public FestivoService(FestivoRepository festivoRepository) {
        this.festivoRepository = festivoRepository;
    }

    public String verificarFestivo(int anio, int mes, int dia) {
        if (!isFechaValida(anio, mes, dia)) {
            return "Fecha no válida";
        }

        boolean esFestivo = festivoRepository.existsByDiaAndMes(dia, mes);
        return esFestivo ? "Es festivo" : "No es festivo";
    }

    private boolean isFechaValida(int anio, int mes, int dia) {
        try {
            LocalDate.of(anio, mes, dia);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static LocalDate calcularDomingoDePascua(int anio) {
        int a = anio % 19;
        int b = anio % 4;
        int c = anio % 7;
        int d = (19 * a + 24) % 30;
        int dias = d + (2 * b + 4 * c + 6 * d + 5) % 7;

        // Marzo tiene 31 días. Si los días pasan de 31, el mes cambia a abril.
        int dia = 15 + dias;
        if (dia > 31) {
            dia -= 31;
            return LocalDate.of(anio, 4, dia); // Abril
        }
        return LocalDate.of(anio, 3, dia); // Marzo
    }

    private boolean esFestivoMovil(int anio, int mes, int dia) {
        LocalDate pascua = calcularDomingoDePascua(anio);
        // Generar las fechas móviles
        LocalDate juevesSanto = pascua.minusDays(3);
        LocalDate viernesSanto = pascua.minusDays(2);
        LocalDate domingoDePascua = pascua;
    
        // Comparar la fecha dada con las fechas móviles
        LocalDate fecha = LocalDate.of(anio, mes, dia);
        return fecha.equals(juevesSanto) || fecha.equals(viernesSanto) || fecha.equals(domingoDePascua);
    }
    
    
}
