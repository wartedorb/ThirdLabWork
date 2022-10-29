import java.util.*;

public class PhoneBook {
    private ArrayList<Record> records = new ArrayList<>();

    public List<Record> getAllRecords() {
        return new ArrayList<>(records);
    }

    public void createRecord(Record record) {
        try {
            for (Record rec : records){
                if(rec.phoneNumber.equals(record.phoneNumber)){
                    throw new PhoneNumberAlreadyExists();
                }
            }
            records.add(record);
        }
        catch (PhoneNumberAlreadyExists e){
            System.out.println(e.getMessage());
        }
    }


    public void updateRecord(Record record){
        try {
            if(record.phoneNumber == null || record.name == null || record.phoneNumber.isEmpty()
                    || record.name.isEmpty()){
                throw new RecordNotValid();
            }
            int i = 0;
            while(i <= records.size() - 1){
                if(i == records.size()-1 && record.id != records.get(i).id ){
                    throw new RecordNotFound();
                } else {
                    if(records.get(i).id == record.id){
                        records.set(i, record);
                        break;
                    }
                }
                i++;
            }

        }
        catch (RecordNotValid | RecordNotFound e){
            System.out.println(e.getMessage());
        }

    }

    public void deleteRecord(long id){
        try {
            for(Record record : records){
                if(record.id == id){
                    records.remove(record);
                    break;
                }
                throw new RecordNotFound();
            }
        }
        catch(RecordNotFound e){
            System.out.println(e.getMessage());
        }
    }






































}
