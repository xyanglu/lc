class Solution {
public:
    unordered_map<int, vector<int>> graph;
    unordered_map<int, char> conn;
    unordered_set<int> visited;
    void createGraph(vector<vector<int>>& edges){
        for(auto &v : edges){
            graph[v[0]].push_back(v[1]);
            graph[v[1]].push_back(v[0]);
        }
    }
    vector<int> dfs(int node, unordered_set<int> &visited, vector<int> & ans){
        if(visited.count(node)){
            vector<int> re;
            return re;
        }
        visited.insert(node);
        vector<int> c(26, 0);
        for(auto &nei : graph[node]){
            vector<int> temp = dfs(nei, visited, ans);
            if (temp.size()){
                for(int i = 0; i < 26; ++i){
                    c[i] += temp[i];
                }

            }
        }
        c[conn[node]-'a']++;
        ans[node] = c[conn[node]-'a'];
        return c;
    }
    vector<int> countSubTrees(int n, vector<vector<int>>& edges, string labels) {
        createGraph(edges);

        for(int i = 0; i < labels.size();++i){
            conn[i] = labels[i];
        }
        vector<int> ans(n);
        dfs(0, visited, ans);
        return ans;

    }
};