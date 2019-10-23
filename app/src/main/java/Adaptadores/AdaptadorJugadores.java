package Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ejercicioxo.R;

import java.util.ArrayList;
import java.util.List;

import Entidades.Jugadores;

public class AdaptadorJugadores extends RecyclerView.Adapter<AdaptadorJugadores.ViewHolder> implements Filterable {

    private static ItemClickCallback itemClickCallback;     //Para el evento click en los items
    public List<Jugadores> lstJugadores;
    public List<Jugadores> lstJugadoresFull;                  //Para el respaldo de la lista al buscar
    ViewHolder viewHolder;
    Context contextActual;

    // ---------- Para el evento click en el cardview ----------
    public interface ItemClickCallback{
        void onItemClick(View v, int position);
    }

    public void setContextActual(Context contextActual) {
        this.contextActual = contextActual;
    }

    public void setItemClickCallback(final ItemClickCallback itemClickCallback){
        this.itemClickCallback = itemClickCallback;
    }
    // ---------- Para el evento click en el cardview ----------

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txvNombrePlantilla, txvGanadasPlantilla;
        CardView cvJugadores;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txvNombrePlantilla = itemView.findViewById(R.id.txvNombrePlantilla);
            txvGanadasPlantilla = itemView.findViewById(R.id.txvGanadasPlantilla);
            cvJugadores = itemView.findViewById(R.id.cvJugadores);

            cvJugadores.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.cvJugadores:{     // ---------- Para el evento click en el cardview ----------
                    itemClickCallback.onItemClick(view, getAdapterPosition());
                    break;
                }
            }
        }
    }

    public AdaptadorJugadores(List<Jugadores> lstJugadores) {
        this.lstJugadores = lstJugadores;
        this.lstJugadoresFull = new ArrayList<>(lstJugadores);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plantilla_jugadores, parent, false);
        viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        //Obtenemos los datos a mostrar
        String ganadas = Integer.toString(this.lstJugadores.get(position).getGanadas());

        holder.txvNombrePlantilla.setText(this.lstJugadores.get(position).getNombre());
        holder.txvGanadasPlantilla.setText(ganadas);
    }

    @Override
    public int getItemCount() {
        if (this.lstJugadores.isEmpty()) {
            return 0;
        } else {
            return this.lstJugadores.size();
        }
    }


    //---------- MÉTODOS PARA LA BÚSQUEDA EN LA LISTA ----------
    @Override
    public Filter getFilter() {
        return repuestoFilter;
    }

    private Filter repuestoFilter = new Filter(){

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<Jugadores> lstFiltrada = new ArrayList<>();

            if(charSequence == null || charSequence.length() == 0){
                lstFiltrada.addAll(lstJugadoresFull);
            } else{
                String filterPattern = charSequence.toString().toLowerCase().trim();

                for(Jugadores item : lstJugadoresFull){
                    if(item.getNombre().toLowerCase().contains(filterPattern)){
                        lstFiltrada.add(item);
                    }
                }
            }

            FilterResults resultados = new FilterResults();
            resultados.values = lstFiltrada;

            return resultados;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            lstJugadores.clear();
            lstJugadores.addAll((List) filterResults.values);
            notifyDataSetChanged();
        }
    };
    //---------- MÉTODOS PARA LA BÚSQUEDA EN LA LISTA ----------
}
